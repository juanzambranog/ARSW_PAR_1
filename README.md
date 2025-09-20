### Escuela Colombiana de Ingeniería
----
### Arquitecturas de Software

----
#### Parcial primer corte
----

#### Juan David Zambrano Gonzalez


----
### **1. Creamos la estructura del proyecto con Spring Initializr**
![alt text](/alpha/src/main/resources/images/image-3.png)

**Luego dentro del proyecto creamos los paquetes de (controllers, models, repository, services)**
![alt text](/alpha/src/main/resources/images/image-4.png)

**AlphaControllers**
![alt text](/alpha/src/main/resources/images/image-5.png)

**Alpha**
![alt text](/alpha/src/main/resources/images/image-6.png)

**AlphaRepository**
![alt text](/alpha/src/main/resources/images/image-7.png)

**AlphaServices**
![alt text](/alpha/src/main/resources/images/image-8.png)

### 2. Hacemos **mvn clean package**
![alt text](/alpha/src/main/resources/images/image-1.png)

Y **mvn spring-boot:run**
    ![alt text](/alpha/src/main/resources/images/image-2.png)

    Luego verificamos en **Postman** que este corriendo con (http://localhost:8080/api/alphas)
    
![alt text](/alpha/src/main/resources/images/image.png)


### 3. Despliegue en **Azure Devops**    

**En este caso usaremos la extension de *Azure Tools***

![alt text](/alpha/src/main/resources/images/image-9.png)

- Creamos un nuevo **App Services**

    ![alt text](/alpha/src/main/resources/images/image-10.png)    

- Lo configuramos y esperamos a que se cree el servicio

    ![alt text](/alpha/src/main/resources/images/image-11.png)

- Una vez creado el servicio, hacemos el **Deploy to web app**

    ![alt text](/alpha/src/main/resources/images/image-12.png)

    ![alt text](/alpha/src/main/resources/images/image-13.png)
