<template>
  <div class="container-fluid" id="app">
    <h1 align="center"></h1>
    <h2 align="center">Tienda Api</h2>
    <br>

      <form @submit.prevent="salvar">

      <div class="form-row">
<div class="col-md-6">
          <label>ID</label>
          <input type="text" class="form-control" disabled placeholder="ID" v-model="factura_producto.id_factura" >
          </div>
              <div class="col-md-6">
          <label>Nombre persona</label>
          <input type="text" class="form-control" placeholder="Nombre"  >
             </div>
      </div>
           <div class="form-row">
              <div class="col-md-6">
          <label>Apellido</label>
          <input type="text" class="form-control" placeholder="Apellido"  >
             </div>
<div class="col-md-6">
               <div class="form-group">
    <label for="exampleFormControlSelect1">Producto</label>
    <select class="form-control" id="selectProducto">
      <option v-for="factura_producto of factura_productos" :key="factura_producto.id">{{factura_producto.nombre}}</option>
    </select>
    </div>
  </div>
      </div>

                 <div class="form-row">
              <div class="col-md-6">
          <label>Cantidad</label>
          <input type="text" class="form-control"  placeholder="Cantidad"  v-model="factura_producto.cantidad" >
             </div>
<div class="col-md-6">

  </div>
      </div>
      <br>

      <button  class="btn btn-primary center">Guardar Venta</button>
      <br>
      <br>
    </form>
<h2 align="center">Productos en stock</h2>
    <table class="table table-striped">
      <thead class="thead-dark">
        <tr>
          <th>Id</th>
          <th>Codigo Unico-Producto</th>
          <th>Nombre Producto</th>
          <th>Cantidad</th>
          <th>Opciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="factura_producto of factura_productos" :key="factura_producto.id">
          <!-- <td>{{ movie }}</td> -->
          <td>{{ factura_producto.id }}</td>
          <td>{{ factura_producto.codigo }}</td>
          <td>{{ factura_producto.nombre }}</td>
          <td>{{ factura_producto.cantidad }}</td>
          <td>
              <!-- <button @click="editar(factura_producto)" class="btn btn-outline-warning btn-sm" >Editar</button> -->
<!--               <button @click="remover(factura_producto)" class="btn btn-outline-danger btn-sm">Eliminar</button> -->
<!--               <button  @click="despacharP(factura_producto)" class="btn btn-outline-primary btn-sm">Despachar Tienda</button> -->
              <button  @click="despacharP(factura_producto)" class="btn btn-outline-warning btn-sm">Solicitar Bodega</button>
            </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import FabricaProducto from './services/tienda'


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

      if(confirm('Solicitar Producto?')){
   FabricaProducto.despachar(factura_producto = {"nombre": factura_producto.nombre, "cantidad": factura_producto.cantidad}).then(resposta => {
          this.factura_producto = {}
          alert('Despachado con exito en bodega!')
          this.listar()
          this.errors = {}
        })

      }
     }

  }

}
</script>