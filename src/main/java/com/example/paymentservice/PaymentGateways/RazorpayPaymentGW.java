package com.example.paymentservice.PaymentGateways;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class RazorpayPaymentGW implements PaymentGateway{

    private RazorpayClient razorpayClient;
   public RazorpayPaymentGW(RazorpayClient razorpayClient){
        this.razorpayClient=razorpayClient;
    }


    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, Long amount) {

      try {
//          JSONObject paymentLinkRequest = new JSONObject();
//          paymentLinkRequest.put("amount", amount);
//          paymentLinkRequest.put("currency", "INR");
//          paymentLinkRequest.put("accept_partial", true);
//          paymentLinkRequest.put("first_min_partial_amount", 100);
//          paymentLinkRequest.put("expire_by", 1691097057);
//          paymentLinkRequest.put("reference_id", orderId);
//          paymentLinkRequest.put("description", "Payment for a order" + orderId);
//          JSONObject customer = new JSONObject();
//          customer.put("name", phoneNumber);
//          customer.put("contact", "Venkatesh Kothapalli");
//          customer.put("email", email);
//          paymentLinkRequest.put("customer", customer);
//          JSONObject notify = new JSONObject();
//          notify.put("sms", true);
//          notify.put("email", true);
//          paymentLinkRequest.put("notify", notify);
//          paymentLinkRequest.put("reminder_enable", true);
//          JSONObject notes = new JSONObject();
//          notes.put("policy_name", "Jeevan Bima");
//          paymentLinkRequest.put("notes", notes);
//          paymentLinkRequest.put("callback_url", "https://example-callback-url.com/");
//          paymentLinkRequest.put("callback_method", "get");

          JSONObject paymentLinkRequest = new JSONObject();
          paymentLinkRequest.put("amount",amount);
          paymentLinkRequest.put("currency","INR");
          paymentLinkRequest.put("accept_partial",false);
          paymentLinkRequest.put("expire_by", 1701886587);
          paymentLinkRequest.put("reference_id",orderId);
          paymentLinkRequest.put("description","Payment for order #" + orderId);
          JSONObject customer = new JSONObject();
          customer.put("name",phoneNumber);
          customer.put("contact","Nikhil Jain");
          customer.put("email",email);
          paymentLinkRequest.put("customer",customer);
          JSONObject notify = new JSONObject();
          notify.put("sms",true);
          notify.put("email",true);
          paymentLinkRequest.put("notify",notify);
          paymentLinkRequest.put("reminder_enable",true);
          paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
          paymentLinkRequest.put("callback_method","get");

          PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

          return payment.get("short_url").toString();
      }
      catch (Exception e){
          System.out.println(e.getMessage());
          return "Something went wrong";
      }
    }
}
