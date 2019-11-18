<template>
  <div class="container-fluid" id="app">
    <h1 align="center"></h1>
    <h2 align="center">Fabrica Api</h2>

      <form @submit.prevent="salvar">

      <div class="form-row">
<div class="col-md-6">
          <label>ID</label>
          <input type="text" class="form-control" disabled placeholder="ID" v-model="factura_producto.id_factura" >
          </div>
              <div class="col-md-6">
          <label>Nombre</label>
          <input type="text" class="form-control" placeholder="Nombre" v-model="factura_producto.nombre" >
             </div>
      </div>
           <div class="form-row">
              <div class="col-md-6">
          <label>Cantidad</label>
          <input type="text" class="form-control" placeholder="Cantidad" v-model="factura_producto.cantidad" >
             </div>
      </div>
      <br>

      <button  class="btn btn-primary center">Guardar</button>
      <br>
      <br>
    </form>

    <table class="table table-striped">
      <thead class="thead-dark">
        <tr>
          <th>Id</th>
          <th>Nombre</th>
          <th>Cantidad</th>
          <th>Opciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="factura_producto of factura_productos" :key="factura_producto.id">
          <!-- <td>{{ movie }}</td> -->
          <td>{{ factura_producto.id }}</td>
          <td>{{ factura_producto.nombre }}</td>
          <td>{{ factura_producto.cantidad }}</td>
          <td>
              <button @click="editar(factura_producto)" class="btn btn-outline-warning btn-sm" >Editar</button>
              <button @click="remover(factura_producto)" class="btn btn-outline-danger btn-sm">Eliminar</button>
              <button  @click="despacharP(factura_producto)" class="btn btn-outline-primary btn-sm">Despachar</button>
            </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import FabricaProducto from './services/fabrica_productos'

export default {
  name: 'app',
  data () {
    return {
      factura_producto:{
        id: '',
        nombre: '',
        cantidad: ''
      },
      factura_productos: [],
      errors: []
    }
  },

  mounted(){
    this.listar()
  },

  methods:{
    
    listar(){
      FabricaProducto.listar().then(resposta => {
        this.factura_productos = resposta.data
      }).catch(e => {
        console.log(e)
      })
    },

        salvar(){

      if(!this.factura_producto.id){

        FabricaProducto.salvar(this.factura_producto).then(resposta => {
          this.factura_producto = {}
          alert('Guardado Con exito!')
          this.listar()
          this.errors = {}
        }).catch(e => {
          this.errors = e.response.data.errors
        })

      }else{

        FabricaProducto.atualizar(this.factura_producto).then(resposta => {
          this.factura_producto = {}
          this.errors = {}
          alert('Actualizado con exito!')
          this.listar()
        }).catch(e => {
          this.errors = e.response.data.errors
        })

      }
      

    }, 

    editar(factura_producto){
      this.factura_producto = factura_producto
    },

    remover(factura_producto){

      console.log(factura_producto.id);
      if(confirm('Desea Eliminar este registro?')){

        FabricaProducto.apagar(factura_producto.id).then(resposta => {
          this.listar()
          this.errors = {}
        }).catch(e => {
          this.errors = e.response.data.errors
        })

      }

     },

     despacharP(factura_producto){
this.factura_producto = factura_producto

      if(confirm('Desea despachar el producto?')){
   FabricaProducto.despachar(factura_producto = {"nombre": factura_producto.nombre, "cantidad": factura_producto.cantidad}).then(resposta => {
         
          alert('Despachado con exito en bodega!')

            if(this.factura_producto.id){
          FabricaProducto.atualizar(factura_producto = {"id": factura_producto.id, "nombre": factura_producto.nombre, "cantidad": 0}).then(resposta => {
          this.factura_producto = {}
          this.errors = {}
          alert('Actualizado con exito!')
        }).catch(e => {
          this.errors = e.response.data.errors
        })
            }
          
          this.listar()
          this.errors = {}
        })

      }
     }

  }

}
</script>