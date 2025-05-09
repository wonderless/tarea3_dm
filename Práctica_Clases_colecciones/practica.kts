//Tarea 1:
/*
Para esta tarea, debes crear una clase de datos llamada Event.

Una instancia de esta clase debería poder almacenar lo siguiente:

El título del evento como una string
La descripción del evento como una string (puede ser nula)
La segmentación del día del evento como una cadena (solo debemos realizar un seguimiento si el evento comienza a la mañana, a la tarde o a la noche)
La duración del evento en minutos como un número entero
*/
//SOLUCION
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int,
)












//Tarea2:
/*
Tu equipo desea que cambies el código de la franja horaria para usar una clase enum. Cuando usas este tipo de clase, tus compañeros de equipo se ven obligados a elegir uno de los valores de franja horaria proporcionados, lo que evita estos tipos de problemas.

La clase enum debería llamarse Daypart. Debería tener tres valores:

MORNING
AFTERNOON
EVENING
 */
 //SOLUCION
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)







//Tarea 3:
//El siguiente código es la forma en la que actualmente crean y almacenan los eventos del usuario.
val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
/*
¿Cuál es la mejor forma de organizar el almacenamiento de estos eventos?

¿Cómo se pueden almacenar todos los eventos en una variable? (Nota: Debe ser flexible, ya que se pueden agregar más eventos. También debe mostrar de manera eficaz el recuento de la cantidad de eventos almacenados en la variable).

¿Qué clase o tipo de datos usarías? ¿Cuál de las siguientes opciones es una forma de agregar más eventos?
*/
//SOLUCION
val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)








//Tarea 4:
/*
Al administrador le gusta cómo está quedando la app, pero decide que el usuario debería poder ver un resumen de sus eventos cortos en función de la duración estos. Por ejemplo, "Tienes 5 eventos cortos".

Un evento "corto" dura menos de 60 minutos.

Si usas el código de variable events de la solución de la tarea anterior, ¿cómo lograrías este resultado?
*/
//SOLUCION
val shortEvents = events.filter { it.durationInMinutes < 60 }
println("You have ${shortEvents.size} short events.")







//Tarea 5:
/*
A tus compañeros de equipo les gusta cómo está quedando la app, pero quieren que los usuarios puedan ver un resumen de todos los eventos y sus franjas horarias.

El resultado debería ser similar al siguiente:


Morning: 3 events
Afternoon: 4 events
Evening: 2 events
Si usas el código de variable events del paso anterior, ¿cómo lograrías este resultado?
*/
//SOLUCION
val groupedEvents = events.groupBy { it.daypart }
groupedEvents.forEach { (daypart, events) ->
    println("$daypart: ${events.size} events")
}




//Tarea 6:
/*
En este momento, tu colega encuentra y muestra el último elemento con el índice. El código utilizado es println("Last event of the day: ${events[events.size - 1].title}").

Tu administrador te sugiere consultar la documentación de Kotlin para encontrar una función que pueda simplificar este código.

¿Qué función encontraste?
*/
//SOLUCION
println("Last event of the day: ${events.last().title}")





//Tarea 7:
//A tu equipo le gusta la clase de datos que diseñaste, pero le resulta repetitivo escribir 
//código cada vez que necesitan la duración de un evento como string:


val durationOfEvent = if (events[0].durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }
println("Duration of first event of the day: $durationOfEvent")
/*
Sin cambiar directamente la clase de datos, ¿cómo puedes escribir una propiedad de extensión
que muestre los mismos valores que el código anterior?

Cuando se implementa correctamente, podrás usar el siguiente código, que mostrará 
el mismo mensaje que el código que se muestra al comienzo de esta tarea.
*/
println("Duration of first event of the day: ${events[0].durationOfEvent}")

//SOLUCION
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }










