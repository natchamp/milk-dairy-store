package com.demo.in.milkdairy.web.rest;

import com.demo.in.milkdairy.generateddomain.ApiUtil;
import com.demo.in.milkdairy.generateddomain.service.dto.Bill;
import com.demo.in.milkdairy.generateddomain.service.dto.BillList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public interface MilkDailyApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /bill/total : Total Bill
     * This endponit will used for getting all customers bill.
     *
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getBillTotal",
            summary = "Total Bill",
            tags = {  },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = BillList.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/bill/total",
            produces = { "application/json" }
    )
    default ResponseEntity<BillList> _getBillTotal(

    ) {
        return getBillTotal();
    }

    // Override this method
    default  ResponseEntity<BillList> getBillTotal() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"bills\" : [ { \"amount\" : \"amount\", \"last_name\" : \"last_name\", \"id\" : \"id\", \"first_name\" : \"first_name\" }, { \"amount\" : \"amount\", \"last_name\" : \"last_name\", \"id\" : \"id\", \"first_name\" : \"first_name\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /bill/{userId} : Get User Bill
     * This endpoint is used for getting the bill for specific user.
     *
     * @param userId  (required)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "getBillUserId",
            summary = "Get User Bill",
            tags = {  },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Bill.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/bill/{userId}",
            produces = { "application/json" }
    )
    default ResponseEntity<Bill> _getBillUserId(
            @Parameter(name = "userId", description = "", required = true) @PathVariable("userId") String userId
    ) {
        return getBillUserId(userId);
    }

    // Override this method
    default  ResponseEntity<Bill> getBillUserId(String userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"amount\" : \"amount\", \"id\" : \"id\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
