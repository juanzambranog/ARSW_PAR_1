### Escuela Colombiana de Ingeniería
----
### Arquitecturas de Software

----
#### Parcial primer corte
----

#### Juan David Zambrano Gonzalez


----
### **1. Creamos la estructura del proyecto con Spring Initializr**
![alt text](/src/main/resources/images/image-3.png)

**Luego dentro del proyecto creamos los paquetes de (controllers, models, repository, services)**
![alt text](/src/main/resources/images/image-4.png)

**AlphaControllers**
![alt text](/src/main/resources/images/image-5.png)

**Alpha**
![alt text](/src/main/resources/images/image-6.png)

**AlphaRepository**
![alt text](/src/main/resources/images/image-7.png)

**AlphaServices**
![alt text](/src/main/resources/images/image-8.png)

### 2. Hacemos **mvn clean package**
![alt text](/src/main/resources/images/image-1.png)

Y **mvn spring-boot:run**
    ![alt text](/src/main/resources/images/image-2.png)

    Luego verificamos en **Postman** que este corriendo con (http://localhost:8080/api/alphas)
    
![alt text](/src/main/resources/images/image.png)


### 3. Despliegue en **Azure Devops**    

**En este caso usaremos la extension de *Azure Tools***

![alt text](/src/main/resources/images/image-9.png)

- Creamos un nuevo **App Services**

    ![alt text](/src/main/resources/images/image-10.png)    

- Lo configuramos y esperamos a que se cree el servicio

    ![alt text](/src/main/resources/images/image-11.png)

- Una vez creado el servicio, hacemos el **Deploy to web app**

    ![alt text](/src/main/resources/images/image-12.png)

    ![alt text](/src/main/resources/images/image-13.png)

- Hacemos la configuracion para CI/CD

    ![alt text](/src/main/resources/images/image-14.png)
    
    ![alt text](/src/main/resources/images/image-15.png)

- Hacemos el .github\ workflows y esperamos a que haga build y deploy

    ![alt text](/src/main/resources/images/image-16.png)

- Hacemos una prueba momentanea con un controller test, para verificar que se desplego correctamente

    ![alt text](/src/main/resources/images/image-17.png)   

- Configuramos la API externa con la API Key otorgada
    ![alt text](image.png)

- Realizamos pruebas de consulta en web y en Postman y obtenemos resultados 
    ![alt text](image-1.png)


    ![alt text](image-2.png)

    - Clase API externa

    ![alt text](image-3.png)


