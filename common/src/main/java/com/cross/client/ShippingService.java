package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.DistributionOrderTemp;
import com.cross.model.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LY on 2017-9-21 09:13:09
 */
@AuthorizedFeignClient(name = "shipping")
public interface ShippingService {

    @PostMapping("api/distribution-orders/create")
    void createDistributionOrder(@Valid @RequestBody DistributionOrderTemp distributionOrderTemp);

    @GetMapping("api/teams/platformId")
    List<Team> getAllTeams(@RequestParam("platformId") Long platformId );
}
