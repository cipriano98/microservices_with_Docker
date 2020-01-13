package com.example.App.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.App.domain.model.EmployeeInfo;

@RefreshScope
@RestController
public class EmployeeInfoController {
    @Autowired
    ServiceProxy proxyService;

    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);
    }

    @RequestMapping("/dashboard/feign/peers")
    public Collection<EmployeeInfo> findPeers() {
        return proxyService.findAll();
    }
}

/*
 * package com.example.App.controller;
 * 
 * import java.nio.file.Path; import java.util.ArrayList; import
 * java.util.Collection;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Value;
 * 
 * import org.springframework.cloud.context.config.annotation.RefreshScope;
 * import org.springframework.http.HttpMethod; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.example.App.domain.model.EmployeeInfo; import
 * com.netflix.appinfo.InstanceInfo; import com.netflix.discovery.EurekaClient;
 * import com.netflix.discovery.shared.Application;
 * 
 * @RefreshScope
 * 
 * @RestController public class EmployeeInfoController {
 * 
 * @Autowired private RestTemplate restTemplate;
 * 
 * @Autowired private EurekaClient eurekaClient;
 * 
 * @Value("${service.employeesearch.serviceId}") private String
 * employeeSearchServiceId;
 * 
 * @RequestMapping("/dashboard/{myse   lf}") public EmployeeInfo
 * findme(@PathVariable Long myself) { Application application =
 * eurekaClient.getApplication(employeeSearchServiceId); InstanceInfo
 * instanceInfo = application.getInstances().get(0); String url = "http://" +
 * instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +
 * "employee/find/" + myself; System.out.println("URL" + url); EmployeeInfo emp
 * = restTemplate.getForObject(url, EmployeeInfo.class);
 * System.out.println("RESPONSE " + emp); return emp; }
 * 
 * @RequestMapping("/dashboard/peers") public Collection<EmployeeInfo>
 * findPeers() { Application application =
 * eurekaClient.getApplication(employeeSearchServiceId); InstanceInfo
 * instanceInfo = application.getInstances().get(0); String url = "http://" +
 * instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" +
 * "employee/findall"; System.out.println("URL" + url); Collection<EmployeeInfo>
 * list = restTemplate.getForObject(url, Collection.class);
 * System.out.println("RESPONSE " + list); return list; } }
 */