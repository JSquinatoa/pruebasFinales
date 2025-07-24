<template>
    <div class="container">
        <VistaVehiculo @vehiculoId="obtenerVehiculo($event)"/>
        <ConsultarVehiculo ref="consVehi"/>
    </div>
</template>

<script>
import ConsultarVehiculo from "@/components/ConsultarVehiculo.vue"
import VistaVehiculo from "@/components/VistaVehiculo.vue"
import { obtenerVehiculoFachada } from "@/clients/VehiculoClient.js";


export default {

    data(){
        return{

        }
    },
    components:{
        ConsultarVehiculo,
        VistaVehiculo
    },

    methods:{
        async obtenerVehiculo(id){
            this.data = await obtenerVehiculoFachada(id);  
            this.$refs.consVehi.vehiculo = this.data            
            this.$refs.consVehi.isCreado = true                

        }
    }

}
</script>

<style>

</style>