WeatherSpringApi

1. EndPoint para crear un usuario
     ENDPOINT URL: http://localhost:8080/auth
     METHOD: POST
     JSON FORMAT:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/0aed6cbe-f5f8-48f6-9e2a-317c381c1209)
     SERVER RESPONSE
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/ff375207-a042-42d4-b0de-691263a07831)
     DATABASE LOG
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/2aa45e8a-fb95-489d-88d6-0ce22e1752d8)

2. EndPoint para loggear un usuario y generar un token.
     ENDPOINT URL: http://localhost:8080/auth/login
     METHOD: POST
     JSON FORMAT:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/c47fd4eb-d6e5-4e2f-b2f5-2e84930500cc)
     SERVER RESPONSE:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/fbba38a1-edc6-4a80-8320-7f436dedacb4)

3. EndPoint para obtener la informacion del clima de una ciudad.
     ENDPOINT URL: http://localhost:8080/weather/current/{city}
     METHOD: GET
     JSON FORMAT:    
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/db453551-1316-4574-bd38-a43c4479519c)
     SERVER RESPONSE:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/82a6072f-3ef8-482e-a334-8390a909fd90)
     DATABASE LOG:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/f4e1f29a-4b97-4397-b0bd-41f86a08b90e)

4. EndPoint para obtener la prediccion del clima en 5 dias siguientes.
     ENDPOINT URL: http://localhost:8080/weather/{city}
     METHOD: GET
     JSON FORMAT: 
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/abd2ff23-fa2b-4c4f-aace-cc576560fddf)
     SERVER RESPONSE:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/b74e2638-c6a6-4b4e-9d0c-ccab20934f69)
     DATABASE LOG:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/e02719ef-bd89-4c90-9379-64cfc9d4f055)

5. EndPoint para obtener la calidad del aire de una ciudad
     ENDPOINT URL: http://localhost:8080/weather/air_pollution/{city}
     METHOD: GET
     JSON FORMAT: 
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/3ab738e3-5af7-474f-b76c-749fd28b07df)
     SERVER RESPONSE:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/1a7349d6-b5a7-448d-b7e1-7572ded46aca)
     DATABASE LOG:
![image](https://github.com/ZeB-ZuA/WeatherSpringAPI/assets/140029785/4790b2b5-0097-4ef4-ad4d-b04a2c79e116)

# 6. EndPoint para listar todas las consultas realizadas junto al usuario que las realizo
   









