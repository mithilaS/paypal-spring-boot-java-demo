# TEST 1 : Steps to run PayPal demo jar
## 1. Change config file data to match with Qalara's credentials

demo.client.id={YOUR-CLIENT-ID} <br>
demo.client.secret={YOUR-CLIENT-SECRET} <br>

demo.baseurl=https://api-m.sandbox.paypal.com/ <br>
demo.order.test2.total.order.amount=100 <br>
demo.order.test1.total.order.amount=1 <br>
demo.order.test1.total.count=50 <br>
demo.authorization.test2.total.count=50 <br>

## 2. Run code using below command. 
###  Change the path to the config file location. Use --trace in command too
nohup java -jar paypaldemo.jar --spring.config.location=file:///D:/paypaldemo/ --trace 


## 3. Open the browser or run curl command in another terminal to run this line.
### Please note the server port is assumed 8082 which is seen in application.properties file.
#### For Browser call below link
http://localhost:8082/paypaldemo/createorder <br>

#### FOR CURL Command
curl -v http://localhost:8082/paypaldemo/createorder

# TEST 2 : Create order and authorize/capture order
## 1. Take latest update of config file. Change config file data to match with Qalara's credentials.

## 2. Run below command to start server
nohup java -jar paypaldemo1.jar --spring.config.location=file:///home/ec2-user/paypal-spring-boot-java-demo-main/jar/  --trace server >>/applicationtest2.log

## 3. Create order using below command.
curl -v http://localhost:8082/paypaldemo/createorder/test2

### 3.2 The response should have the order id and the approval link. <br>
### 3.3 Approve the order from the browser by login to PayPal.
### 3.4 Copy the order id to pass it to next request

## 4. Call authorization, capture on the above order.
Here orderId = The order id which was successfully created. delaytime=2000ms which is 2seconds. totalcount=50 to create 50 auth-capture request. saveorder=true to first save the order.

http://localhost:8082/paypaldemo/createAuthCapture/test2?orderId=12345&delaytime=2000&totalcount=50&saveorder=true







