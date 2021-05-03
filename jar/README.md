# Steps to run PayPal demo jar
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
java -jar paypaldemo.jar --spring.config.location=file:///D:/paypaldemo/ --trace 


## 3. Open the browser or run curl command in another terminal to run this line.
### Please note the server port is assumed 8082 which is seen in application.properties file.
#### For Browser call below link
http://localhost:8082/paypaldemo/createorder <br>

#### FOR CURL Command
curl -v http://localhost:8082/paypaldemo/createorder




