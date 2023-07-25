package com.cnkonica.demo.example.common.utils;

import com.cnkonica.demo.example.common.exception.BizResultCode;
import com.cnkonica.demo.example.common.exception.ResultCode;
import com.cnkonica.demo.example.common.global.GlobalResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @Test
    void testSuccess1() {
        // Setup
        // Run the test
        final GlobalResponse<String> result = Results.success("data");

        // Verify the results
        assertThat(BizResultCode.SUCCESS.getCode()).isEqualTo(result.getCode());
    }

//    @Test
//    void testSuccess2() {
//        // Setup
//        // Run the test
//        final GlobalResponse<String> result = Results.success();
//
//        // Verify the results
//    }
//
//    @Test
//    void testError1() {
//        // Setup
//        // Run the test
//        final GlobalResponse<String> result = Results.error();
//
//        // Verify the results
//    }
//
//    @Test
//    void testError2() {
//        // Setup
//        // Run the test
//        final GlobalResponse<String> result = Results.error("message");
//
//        // Verify the results
//    }
//
//    @Test
//    void testError3() {
//        // Setup
//        // Run the test
//        final GlobalResponse<String> result = Results.error("code", "message");
//
//        // Verify the results
//    }
//
//    @Test
//    void testError4() {
//        // Setup
//        final ResultCode resultCode = null;
//
//        // Run the test
//        final GlobalResponse<String> result = Results.error(resultCode);
//
//        // Verify the results
//    }
}
