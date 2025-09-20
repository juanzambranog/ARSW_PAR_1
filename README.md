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
















# Docs for the Azure Web Apps Deploy action: https://github.com/Azure/webapps-deploy
# More GitHub Actions for Azure: https://github.com/Azure/actions

name: Build and deploy JAR app to Azure Web App - Alpha

on:
  push:
    branches:
      - main
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    permissions:
      contents: read #This is required for actions/checkout

    steps:
      - uses: actions/checkout@v4

      - name: Set up Java version
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'microsoft'

      - name: Build with Maven
        run: mvn clean install

      - name: Upload artifact for deployment job
        uses: actions/upload-artifact@v4
        with:
          name: java-app
          path: '${{ github.workspace }}/target/*.jar'

  deploy:
    runs-on: ubuntu-latest
    needs: build
    permissions:
      id-token: write #This is required for requesting the JWT
      contents: read #This is required for actions/checkout
  
    steps:
      - name: Download artifact from build job
        uses: actions/download-artifact@v4
        with:
          name: java-app
      
      - name: Login to Azure
        uses: azure/login@v2
        with:
          client-id: ${{ secrets.AZUREAPPSERVICE_CLIENTID_1821BD95A2EA4DB38F521065A494B1C1 }}
          tenant-id: ${{ secrets.AZUREAPPSERVICE_TENANTID_020101F98F3C40B88EF2B5994BE42544 }}
          subscription-id: ${{ secrets.AZUREAPPSERVICE_SUBSCRIPTIONID_AC9060AE6B504A75946B48BB45196FD3 }}

      - name: Deploy to Azure Web App
        id: deploy-to-webapp
        uses: azure/webapps-deploy@v3
        with:
          app-name: 'Alpha'
          slot-name: 'Production'
          package: '*.jar'

