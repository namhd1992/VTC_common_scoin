/***************************************************************************
 * Product 2018 by Quang Dat * 
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common;

/**
 * Creator : Le Quang Dat
 * Email   : quangdat0993@gmail.com
 * Date    : Aug 27, 2018
 */
public enum EnvironmentKey {
    
// # ===============================
// # CONFIG
// # ===============================
    
    SPLAY_API_SECRET("splay.api.secret"),
    
    PROJECT_BASE_URL("project.pay.url"), 
    
    HEADER_BASE_URL("header.base.url"),
    
    SCOIN_LIVE_CLIENTID("scoin.live.clientId"),
    
    TOPUP_CARD_HISTORY_API_KEY("topup.card.history.api.key"),
    
    TOPUP_CARD_HISTORY_API_URL("topup.card.history.api.url"),
    
    
    
    
// # ===============================
// # SANBOX
// # ===============================
    
//  -------------------------- SIGNIN SCOIN --------------------
    
    SANDBOX_SCOIN_SIGNIN_GET_ACCESS_TOKEN_URL("sandbox.scoin.signin.get.access.token.url"),
    
    SANDBOX_SCOIN_SIGNIN_GET_PROFILE_URL("sandbox.scoin.signin.get.profile.url"),
    
    SANDBOX_SCOIN_SIGNIN_CLIENTID("sandbox.scoin.signin.clientId"),
    
    SANDBOX_SCOIN_SIGNIN_CLIENTSECRET("sandbox.scoin.signin.clientSecret"),
    
    SANDBOX_SCOIN_SIGNIN_AGENCYID("sandbox.scoin.signin.agencyId"),
    
//  -------------------------- BALANCE SCOIN ----------------------
    SANDBOX_SCOIN_BALANCE_SCOIN_URL("sandbox.scoin.balance.scoin.url"),
    
    
//  -------------------------- XU ----------------------
    SANDBOX_XU_API_URL("sandbox.scoin.xu.url"),
    
    SANDBOX_XU_API_KEY("sandbox.scoin.xu.api.key"),
    
    SANDBOX_XU_SECRET_KEY("sandbox.scoin.xu.secret.key"),
    
    
//  -------------------------- CARD --------------------
    SANDBOX_FUND_REQUEST_CARD_API_URL("sandbox.fund.request.scoin.card.url"),
    
    SANDBOX_CARD_API_KEY_DECODE_TRIPLEDES("sandbox.scoin.card.key.decode.tripleDES"),
    
    
//  -------------------------- TỦ ĐỒ SCOIN --------------------
    SANDBOX_TUDO_URL("sandbox.scoin.tudo.url"),
    
    SANDBOX_TUDO_API_KEY("sandbox.scoin.tudo.api.key"),
    
    SANDBOX_TUDO_API_SECRET("sandbox.scoin.tudo.api.secret"),
    
    
    
// # ===============================
// # LIVE
// # ===============================
    
//  -------------------------- SIGNIN SCOIN --------------------
    
    LIVE_SCOIN_SIGNIN_GET_ACCESS_TOKEN_URL("live.scoin.signin.get.access.token.url"),
    
    LIVE_SCOIN_SIGNIN_GET_PROFILE_URL("live.scoin.signin.get.profile.url"),
    
    LIVE_SCOIN_SIGNIN_CLIENTID("live.scoin.signin.clientId"),
    
    LIVE_SCOIN_SIGNIN_CLIENTSECRET("live.scoin.signin.clientSecret"),
    
    LIVE_SCOIN_SIGNIN_AGENCYID("live.scoin.signin.agencyId"),
    
    
//  -------------------------- BALANCE SCOIN ----------------------
    LIVE_SCOIN_BALANCE_SCOIN_URL("live.scoin.balance.scoin.url"),
    
//    -------------------------- XU ----------------------
    LIVE_XU_API_URL("live.scoin.xu.url"),
    
    LIVE_XU_API_KEY("live.scoin.xu.key"),
    
    LIVE_XU_SECRET_KEY("live.scoin.xu.secret.key"),
    
    
//  -------------------------- CARD --------------------
    LIVE_FUND_REQUEST_CARD_API_URL("live.fund.request.scoin.card.url"),
    LIVE_CARD_API_KEY_DECODE_TRIPLEDES("live.scoin.card.key.decode.tripleDES"),
    
//  -------------------------- TỦ ĐỒ SCOIN --------------------
    LIVE_TUDO_URL("live.scoin.tudo.url"),
    
    LIVE_TUDO_API_KEY("live.scoin.tudo.api.key"),
    
    LIVE_TUDO_API_SECRET("live.scoin.tudo.api.secret"),
    
    ;
    
    
    
    private String key;

    EnvironmentKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
