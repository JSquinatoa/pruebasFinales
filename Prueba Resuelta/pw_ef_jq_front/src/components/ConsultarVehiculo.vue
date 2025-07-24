<template>
  <div class="container" v-if="isCreado">
    <div class="form" >
      <button @click="cerrar()">cerrar</button>
      <p type="Placa"><input type="text" v-model="vehiculo.placa" disabled /></p>
      <p type="Marca"><input type="text" v-model="vehiculo.marca" disabled /></p>
      <p type="Modelo"><input type="text" v-model="vehiculo.modelo" disabled /></p>
      <p type="Colro"><input type="text" v-model="vehiculo.color" disabled /></p>
      <p type="Precio"><input type="number" v-model="vehiculo.precio" disabled /></p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isCreado: false,
      vehiculo: []
    }
  },
  methods:{
    cerrar(){
        this.isCreado = false
    }
  }
};
</script>

<style scoped>
.container {
  display: flex;
  width: 100%;
  position: absolute;
  top: 25%;
  background-color: gray;
}

.form {
  display: flex;
  flex-direction: column;
  width: 25%;
  background-color: white;
  border-radius: 25px;
  padding: 10px 25px;
}

p::before {
  display: block;
  content: attr(type);
  text-align: left;
}

input {
  width: 100%;
  border: none;
  border-bottom: 1px solid;
}

input:focus {
  outline: none;
}
</style>