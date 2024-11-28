2. Diagrama de Secuencia para Reservar un Libro
Actor (Usuario) inicia la reserva.

Sistema verifica la disponibilidad del Libro.

Sistema confirma la reserva y actualiza el estado del Libro.

Sistema notifica al Usuario sobre el estado de la reserva.

Usuario -> Sistema: Inicia reserva de libro
Sistema -> Libro: Verifica disponibilidad
Libro -> Sistema: Respuesta de disponibilidad
Sistema -> Sistema: Actualiza estado de reserva
Sistema -> Usuario: Notifica estado de reserva
