# Simple CRUD using Spring and ReactJS

This is a simple app, demonstrating simple CRUD operations on two entities 'Employee' and 'Department'.

This is dont using Spring boot (refer to POM for complete dependencies used) and ReactJS with Material-UI.

## Installation

### FrontEnd
Use the node package manager in the 'frontend/reactproject2' to run the following:

```bash
npm install

npm start
```

The first will take care of all required dependencies, the second will start the app on port 3000 (default)

P.S make sure you installed node first to be able to use npm

### Backend

Use maven to download all dependencies required for backend with the following:
```bash
mvn install
```
 This will take care of compiling the source code, packaging the project and installing it in the local repository.
## Usage

### Backend
You can run the code with your favorite IDE easily, or you can run the fat jar from the previous step directly by
```bash
java -jar /path-to-jar 
```
The jar contains all the code and dependencies including embedded tomcat, running by default on port 8080
### FrontEnd

Now you can start using the browser by visitng
```bash
http://localhost:3000/
```
For more info about endpoint used between Frontend and backend, have a look at swagger, open the following url using your browser

```bash
http://localhost:8080/swagger-ui.html
```
You can find all the logs in Backend/logs folder, the logs are archived daily, all can be changed in log4j2.xml file, for example:
```bash
<RollingFile name="debugAppender" fileName="logs/debug.log" filePattern="logs/$${date:yyyy-MM}/debug%d{MM-dd-yyyy HH}-%i.log.zip" level="debug">
```


## License 
feel free to modify or use this code :)