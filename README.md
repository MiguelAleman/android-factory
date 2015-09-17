# Instrucciones para comenzar a desarrollar en Android

<center>![Android Factory](https://github.com/MiguelAleman/android-factory/blob/master/images/android_factory.png "Android Factory")</center>

Estas son las instrucciones necesarias para comenzar a desarrollar en Android. Deben completar estos pasos antes de el taller ya que normalmente toma bastante tiempo instalar todos los componentes necesarios.

### Instalar Java Development Kit (JDK)

* Verificar si tienen el JDK instalado. Para esto vayan al command line  y escriban java -version. Si les sale un error o tienen una version menor de 7 seguir la próxima instrucción.
* Entrar al siguiente [link](http://www.oracle.com/technetwork/java/javase/downloads/index.html). Bajar el Java Platform (JDK 8u60), escoger la versión que corresponde a su sistema operativo. Instalar.

### Instalar Android Studio

* Entrar al siguiente [link](http://developer.android.com/sdk/index.html). ""*Download Android Studio for Mac*" o "*Download Android Studio for Windows*".
* Instalar el archivo bajado.
* Asegurense en el proceso de instalación de instalar tanto Android Studio como el Android SDK.
* Una vez instalado, abrir Android Studio y permitir que se bajen los componentes del Android SDK. (Puede tomar tiempo)
* Una vez termine el proceso veremos una pantalla como esta:

<center>![Welcome Page](https://github.com/MiguelAleman/android-factory/blob/master/images/welcome.png "Welcome Page")</center>


* Dirigirse a Configure/SDK Manager

### SDK Manager

* En esta ventana podremos bajar los APIs necesarios para comenzar a desarrollar en Android:

<center>![SDK Manager](https://github.com/MiguelAleman/android-factory/blob/master/images/sdk_manager.png "SDK Manager")</center>

* Simplemente dejen los paquetes que fueron seleccionados automaticamente y presionen “Install packages”. Pueden bajar mas APIs si asi lo desean. Siempre es recomendable tener al menos la ultima version.

* Para terminos de el taller estaremos utilizando Android 5.0.1 (API 21). Asegurense de tener el API 21 instalado.

### Testing
* Para las personas que no tienen un dispositivo Android y desean correr sus aplicaciones les aconsejo que bajen [Genymotion](https://www.genymotion.com/#!/). Sigan las instrucciones de como instalarlo ya que es requerido tambien tener instalado [VirtualBox](https://www.virtualbox.org). Si van a utilizar este emulador, traten de crear un dispositivo con API mayor o igual a 21 antes de el taller.

### Meme Creator App

Pueden bajar el codigo que estuvimos trabajando en el taller de dos maneras:
* Si conoces de git, pueden hacer
**"git clone https://github.com/MiguelAleman/android-factory.git"** utilizando el command line/terminal.
* Otra forma es bajar el zip file, este opcion se encuentra a la parte derecha de la pantalla de este repositorio. Luego de bajar el proyecto, descomprimir el zip file e importar el proyecto **Android Factory** en Android Studio.

### Información

* Si tienen alguna duda se pueden comunicar conmigo a través del correo electronico: **miguel.aleman@upr.edu**.
