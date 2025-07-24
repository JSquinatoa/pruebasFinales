import axios from "axios";

const URL_API = "http://localhost:8081/api/concesionario/v1/vehiculos"

const crearVehiculo = async (body) => {
    axios.post(URL_API, body);
}

const eliminarVehiculo = async (id) => {
    axios.delete(`${URL_API}/${id}`)
}

const obtenerTodosVehiculos = async () => {
    const response = axios.get(URL_API).then(res => res.data)    
    return response
}

const obtenerVehiculo = async (id) => {
    const response = axios.get(`${URL_API}/${id}`).then(res => res.data)
    return response
}

// Funciones Facahda
export const crearVehiculoFachada = async (body) => {
    await crearVehiculo(body);
}

export const eliminarVehiculoFachada = async (id) => {
    await eliminarVehiculo(id);
}

export const obtenerTodosVehiculosFachada = async () => {
    return await obtenerTodosVehiculos();
}

export const obtenerVehiculoFachada = async (id) => {
    return await obtenerVehiculo(id);
}

