import axios from 'axios'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '';
axios.defaults.headers.common['Access-Control-Allow-Methods'] = ''  
export const http = axios.create({
    baseURL: 'http://localhost:8028/bodega/',
});

export const http2 = axios.create({
    baseURL: 'http://localhost:8011/fabrica/',
});