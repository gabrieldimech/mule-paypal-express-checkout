# mule-paypal-express-checkout

This app is intended to demo how to use paypal express checkout in Mule 3.7+

Note: this project is not using maven yet as the paypal connector is not yet in th epublic repo at the time of writing.

Steps to run the app:

step 1 - Run the app and Send a request via browser to the following URL, note the params:

http://localhost:8081/start-express-checkout?paymentAction=Sale&orderTotal=10.00&currency=GBP

step 2 - user is redirected to paypal, must enter user name and pass and confirm payment

step 3 - paypal forwards payer id and token to the return url configured in the paypal request via mule (hard coded values in data mapper):

http://google.com/paypal-reply?token=EC-5UV35559HL2178137&PayerID=8LU98BNRVPXNS

Since the above request will fail and timeout (add live URLs here so that you can receive the paypal return data) , you are able to retrieve payerID and token as shown above from the browser redirection.

step 4 - Manually invoke the paypal-reply flow by simply replacing google.com with localhost from the above failed redirect, i.e:

http://localhost/paypal-reply?token=EC-5UV35559HL2178137&PayerID=8LU98BNRVPXNS

This step invokes an optional get-express-checkout details (may be used for audit purposes) and do-express-checkout which completes the transaction.

If successful you should see an XML response.