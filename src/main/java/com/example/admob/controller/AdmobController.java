package com.example.admob.controller;

import com.google.crypto.tink.apps.rewardedads.RewardedAdsVerifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.GeneralSecurityException;

@RestController
public class AdmobController {
    @GetMapping("/hello")
    public String hello(){
        String rewardUrl="https://admob.500.com.songchao.win/adMobSuccess?ad_network=5450213213286189855&ad_unit=4075738622&reward_amount=1&reward_item=sdc&timestamp=1564744089011&transaction_id=233a2412ef448c463ad79b4956ca3f66&signature=MEUCIQDvSQRk2_lIkQjKoWxI8POerBYnLmXaDvSB6c_g7bqwngIgNYPbeUkyveKwJZRPX_uxSuuspIczIaY1dc1c9xcNLak&key_id=3335741209";
        try {
            VerifyErrorAdMod(rewardUrl);
        }catch (Exception e){
            return e.toString();
        }
        return "hello Spring boot";
    }

    @GetMapping("/adMobSuccess")
    public Integer adMobSuccess(){

        return 0;
    }

    private void VerifyErrorAdMod(String rewardUrl) throws GeneralSecurityException {
        RewardedAdsVerifier verifier = new RewardedAdsVerifier.Builder()
                .fetchVerifyingPublicKeysWith(
                        RewardedAdsVerifier.KEYS_DOWNLOADER_INSTANCE_PROD)
                .build();
        verifier.verify(rewardUrl);
    }
}
