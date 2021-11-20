# DB_2
REST API

+++--- USER ---+++
POST (http://localhost:8080/user/registration) 
  body("email","username","password")
returns an int(the autogenerated id of the user);//In caso di errore da una risposta di errore "409" con "message" che spiega il perche

POST (http://localhost:8080/user/login)
    body(email,password)
returns a user; //In caso di errore da una risposta di errore "409" con "message" che spiega il perche

GET (http://localhost:8080/getorders/{user_id})
  NON richiede body ma solo l'user_id come path variable (esempio: PEr avere tutti gli ordini dell'utente con id 112 semplicemente si fa una get ad (http://localhost:8080/getorders/112"))
 ritorna una LISTA DI ORIDNI; // in caso di errore ripsonde con il codice 401 e con "message" contenente la spiegazione


+++--- EMPLOYEE ---+++
POST (http://localhost:8080/employee/registration) 
  body("email","password")
returns an int(the autogenerated id of the employee);//In caso di errore da una risposta di errore "409" con "message" che spiega il perche

POST (http://localhost:8080/employee/login)
    body(email,password)
returns a employee; //In caso di errore da una risposta di errore "409" con "message" che spiega il perche



+++--- PACKAGE ---+++
GET (http://localhost:8080/package/getall)
  returns all the packages; 
->response body example:
[{"id":111,"name":"home package","fee12":18.99,"fee24":16.99,"fee36":14.99,"employee":null,
"services":
    [{"id":111,"type":"fixed phone","minutes":null,"sms":null,"internet":null,"minutes_fee":null,"sms_fee":null,"internet_fee":null},             
    {"id":112,"type":"fixed internet","minutes":null,"sms":null,"internet":100,"minutes_fee":null,"sms_fee":null,"internet_fee":100.0}],
"optionalProducts":
    [{"id":111,"name":"TimVision","monthly_fee":8.99}]}]
    
POST (http://localhost:8080/package/getall) //crea nuovo package
  BODY:    form paramaters(String name, Float fee12, Float fee24, Float fee36, int employee_id, List<Integer> services_id,List<Integer> prods_id) 
    returns new package id;
//N.B. per inviare una richiesta con una lista di prods_id basta chiamare piu parametri prods_id.
  
+++--- ORDER ---+++
POST (http://localhost:8080/order/create)
  BODY: form parameters(    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startSub, int validity, int user_id, int package_id, List<Integer> prod_ids ) 
return new order id; 
 P.S.: fare attenzione al formato della data startSub che viene pasata!

  
  
  PUT (http://localhost:8080/order/simulatePayment{order_id})
  return new order status; // status = 1 ordine pagato status>1 ordine non pagato 
 
  PUT (http://localhost:8080/order/payed{order_id}) //rende l'ordine pagato, ovvero pone status=1
  returns new order status;

  PUT (http://localhost:8080/order/refuse{order_id}//rende l'ordine rigettato, ovvero pone status>1
  return new order status;


