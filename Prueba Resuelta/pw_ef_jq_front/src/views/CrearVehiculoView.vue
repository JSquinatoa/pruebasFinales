<template>
  <div class="container_crear">
    <h1>Crear un nuevo vehiculo</h1>
    <div class="form">
        <p type="Placa"><input type="text" placeholder="Ingrese la placa" v-model="placa"></p>
        <p type="Marca"><input type="text" placeholder="Ingrese la marca" v-model="marca"></p>
        <p type="Modelo"><input type="text" placeholder="Ingrese el modelo" v-model="modelo"></p>
        <p type="Colro"><input type="text" placeholder="Ingrese el color" v-model="color"></p>
        <p type="Precio"><input type="number"  placeholder="0.00" v-model="precio"></p>
    </div>
    <button @click="crear()"> Crear </button>
    <h1 v-if="isCreado">Vehiculo Creado Correctamente</h1>
  </div>
</template>

<script>
import { crearVehiculoFachada } from "@/clients/VehiculoClient";


export default {

    
    data(){
        return{
            placa:"",
            marca:"",
            modelo:"",
            color:"",
            precio:"",
            isCreado:false
        }
    },
    methods:{
        async crear(){
            const Vehiculo ={
                placa: this.placa,
                marca: this.marca,
                modelo: this.modelo,
                color: this.color,
                precio: Math.round(this.precio * 100)/100
            }
            if (this.isCreado === false) {                
                await crearVehiculoFachada(Vehiculo)
            }

            this.isCreado = true;
            setTimeout(() => {
                this.isCreado = false
                this.reiniciar();                
            }, 2000);

        },
        reiniciar(){
            this.placa = "";
            this.marca = "";
            this.modelo = "";
            this.color= "";
            this.precio= "";
        }
    }

}
</script>

<style>
.container_crear{
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    border: 1px solid;
    border-radius: 20px;
    background-color: azure;
    padding: 25px 0;
    gap: 10px;
}

.form{
    display: flex;
    flex-direction: column;
    width: 25%;
    background-color: white;
    border-radius: 25px;
    padding: 10px 25px;
}

p::before{
    display: block;
    content: attr(type);
    text-align: left; 


}

input{
    width: 100%;
    border: none;
    border-bottom: 1px solid;
}

input:focus{
    outline: none;
}

button{
    border-radius: 20px;
    padding: 5px 20px;
}

</style>

