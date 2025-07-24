<template>
    <div class="container-table">
        <button @click="consultar()"> Consultar</button>
        <div class="vehi_table">
            <table v-if="data != null" border="1" cellspacing="0">
                <thead>
                    <tr>
                        <th>Placa</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Accion</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody v-if="data != null">
                    <tr v-for="vehiculo in data" :key="vehiculo.id">
                        <td>{{vehiculo.placa}}</td>
                        <td>{{vehiculo.marca}}</td>
                        <td>{{vehiculo.modelo}}</td>
                        <td><button @click="comunicarId(vehiculo.id)">Ver</button></td>
                        <td><button @click="eliminar(vehiculo.id)">Borrar</button></td>
                    </tr>
                </tbody>

            </table>
        </div>

    </div>
</template>

<script>
import { obtenerTodosVehiculosFachada, eliminarVehiculoFachada } from "@/clients/VehiculoClient.js";
export default {
    
    data(){
        return{
            data:null,
            isBorrado: false
        }
    },
    methods:{
        async consultar(){
            console.log(this.data);            
            this.data = await obtenerTodosVehiculosFachada();
            console.log(this.data);            
            
        },
        async eliminar(id){
            if (!this.isBorrado) {                
                await eliminarVehiculoFachada(id)
            }
            this.isBorrado = true;
            setTimeout(() => {
                this.consultar();   
                this.isBorrado = false             
            }, 500);                
        },
        comunicarId(id){
            if (!this.isBorrado) {                
                this.$emit("vehiculoId", id)
            }
        }

    }

}
</script>

<style>
.container-table{
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 50px;
    align-items: center;
    border: 1px solid;    
}

table{
    width: 1000px;
}
</style>