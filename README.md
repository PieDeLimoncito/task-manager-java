# 🧩 Task Manager - Java (POO)

## 📌 Descripción

Este proyecto consiste en un sistema de gestión de tareas desarrollado en Java, enfocado en aplicar los principios fundamentales de la Programación Orientada a Objetos (POO).

Permite la creación y administración de usuarios y tareas, así como la asignación de tareas a usuarios y el seguimiento de su estado (pendiente o completada).

---

## 🎯 Objetivos del proyecto

* Aplicar conceptos de POO:

  * Encapsulamiento
  * Responsabilidad de clases
  * Separación de lógica (Services vs Entities)
* Manejo de colecciones (`List`)
* Uso de validaciones y excepciones
* Comprensión del manejo de referencias en memoria
* Construcción de una base evolutiva hacia arquitectura backend

---

## ⚙️ Funcionalidades

* ✅ Crear usuarios
* ✅ Crear tareas
* ✅ Listar usuarios
* ✅ Listar tareas
* ✅ Asignar tareas a usuarios
* ✅ Marcar tareas como completadas
* ✅ Listar tareas por usuario

---

## 🧱 Estructura del proyecto

```
model/
    Usuario.java
    Tarea.java

service/
    UsuarioService.java
    TareaService.java

app/
    Main.java
```

---

## 🧠 Diseño actual

El sistema sigue una arquitectura básica en capas:

* **Model** → Representa las entidades del dominio (`Usuario`, `Tarea`)
* **Service** → Contiene la lógica de negocio
* **Main** → Interfaz de consola para interacción con el usuario

---

## ⚠️ Consideraciones técnicas

* Se utilizan excepciones (`IllegalArgumentException`) para validaciones
* Los servicios gestionan el acceso y control de datos
* Se evita exponer directamente las listas internas mediante estructuras inmutables (`List.copyOf()`)

---

## 🚀 Estado del proyecto

```
Versión actual: v1
Estado: Funcional (POO básica)
```

---

## 🔄 Próximas mejoras (roadmap)

* Implementación de DTOs (Data Transfer Objects)
* Creación de Mappers para conversión de datos
* Separación más clara de capas
* Preparación para arquitectura tipo backend (API REST)
* Posible integración con frameworks como Spring Boot

---

## 🛠️ Tecnologías utilizadas

* Java
* Programación Orientada a Objetos (POO)
* Colecciones (`List`, Streams)

---

## 📚 Aprendizaje

Este proyecto no solo busca funcionar, sino evolucionar progresivamente hacia un diseño más profesional, simulando el crecimiento de un sistema real.

---

## 👨‍💻 Autor

Desarrollado como parte de un proceso de aprendizaje enfocado en convertirse en desarrollador backend/fullstack.





