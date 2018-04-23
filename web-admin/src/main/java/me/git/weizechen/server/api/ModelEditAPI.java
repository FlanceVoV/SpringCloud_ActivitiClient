package me.git.weizechen.server.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Shadow on 2018/04/17.
 * 调用远程api
 */
@FeignClient(name="activiti")
public interface ModelEditAPI {

    @RequestMapping(value="/service/model/{modelId}/json")
    Object editModel(@RequestParam("modelId") String modelId);

    @RequestMapping(value = "/service/model/{modelId}/save", method = RequestMethod.PUT)
    void saveModel(@RequestParam("modelId") String modelId,
                     @RequestParam("name") String name,
                     @RequestParam("json_xml") String json_xml,
                     @RequestParam("svg_xml") String svg_xml,
                     @RequestParam("description") String description);



}