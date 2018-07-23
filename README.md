## Predicción del clima de la Galaxia lejana



En una galaxia muy lejana existen tres planetas: Vulcanos, Ferengis, y Betazoides. Dominan la predicción del clima en su sistema solar.

### Problema a Resolver

La predicción del clima se realiza bajo las siguientes condiciones.

Condicion | Clima
--- | --- 
Los planetas y el son estan alineados | Sequia
Los tres planetas forma un triangulo y el sol se encuentra dentro. | Lluvia
Maximo perimetro formado en la figura del triangulo se considera que habra. | Maximo pico de intensidad de Lluvia.
Los tres planetas estan alineas pero no el sol. | Optimas condiciones de Presion y temperatura.

### Objetivos

Predecir las condiciones del clima para los proximos diez anios.


* Cuantos periodos de sequía habrá.
* cuantos periodos de lluvia habrá.
* Que dia sera el pico máximo de lluvia.
* Cuantos periodos de condiciones óptimas de presión y temperatura habrá.


### El sistema informático debe contemplar las siguientes implementaciones

* Generar un modelo de datos y base de datos para almacenar las condiciones climáticas de los próximos 10 años y adelante.
* Implementar un API Rest para la consulta la condición del clima de un dia particular.
* Subir a la nube el modelo de datos y el servicio Rest.

#### Límites y alcances estado inicial de la Galaxia

Para resolver el escenario de previsiones de la Galaxia lejana. se está haciendo las siguientes consideraciones en el estado inicial de la galaxia.

1. Se inicia el tiempo en el dia 0.
2. Se está considerando que todos los años son de 365 días.
3. La ubicación de los planetas están en coordenadas polares (distancia, grados) y se convertirá a coordenadas cartesianas (x,y). para lo cual se manejara dos decimales de precisión.
4. A continuación se muestra el estado inicial de la galaxia dentro de un sistema de coordenadas.



