# Cómo preparar, asignar y configurar variables de entorno de tu contenedor Java en OpenShift
Este repositorio contiene un instructivo y una aplicación de prueba para entender y configurar variables de entorno de una aplicación Java y cómo éstas se traducen a un despliegue de un clúster de OpenShift

## Variables de entorno en Java
Java revisa todas las variables de entornos definidas en la sesión actual de tu terminal y a partir de ella extrae todas las definiciones. Éstas pueden ser accedidas mediante el comando `String variableName = System.getenv("variableName")` o en su defecto `Map<String, String> env = System.getenv()` para obtener todos los pares clave-valor de la sesión actual.

Posteriormente extraída la/las variable/s de entorno se pueden trabajar como cualquier otra variable.

## Cambios en el Dockerfile
Si queremos trabajar con variables de entorno, es necesario agregar una línea dentro de nuestro Dockerfile que le diga al contenedor que se está definiendo una variable de entorno, esto se hace mediante la capa `ENV Key Value`
* **ENV** es el identificador del Dockerfile para las variables de entorno
* **Key** es el nombre de la variable de entorno
* **Value** es el valor de la variable de entorno (son siempre de tipo **String**)

## Secrets de un Clúster
Los secrets de un clúster de OpenShift son pares clave-valor que se pueden inyectar dentro de un contenedor de la misma manera que la capa ENV de los Dockerfile. Debemos residir en utilizar secrets debido a que los ENV necesariamente necesitan el par clave-valor y no vamos a construir una imagen distinta por cada posible configuración. Los secrets nos permiten inyectar esta capa dentro de nuestro Dockerfile, permitiendo que solo necesitemos una imagen y solo cambiemos el secret según la configuración que querramos hacer.

# Demo
Esta sección es un paso a paso de como crear, configurar, desplegar y bindear una aplicación de Java con secrets de OpenShift
## Adaptar la aplicación de Java
Antes que nada, debemos preparar la aplicación de Java para que soporte las variables de entorno, debemos cambiar estas variables de configuración o aquellas que sabremos que van a cambiar a que soporten una variable de entorno con un nombre específico
## Probar que las variables de entorno funcionan
Como punto intermedio, puedes crear una imagen de prueba que contenga la capa **ENV** y de esa manera revisar si la inyección se está realizando de manera correcta
## Despliegue en OpenShift
El despliegue en OpenShift se realiza de la misma forma que cualquier otro proceso **From Git** (Source to Image) o **From Dockerfile** lo que nos importa es la opción **Build Configuration** donde se nos presentará una lista donde asignar los pares clave-valor para el despliegue.

# Consideraciones finales
* Todos los secrets y variables de entorno son Strings por defecto
* La clave del secret debe tener exactamente el mismo nombre que la clave de la variable de entorno
