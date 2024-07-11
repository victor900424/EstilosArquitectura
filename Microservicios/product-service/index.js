const express = require('express');
const app = express();
const PORT = 3002;

app.get('/products', (req, res) => {
  res.json([{ id: 1, name: 'Producto A' }]);
});

app.listen(PORT, () => {
  console.log(`Servicio de productos escuchando en el puerto ${PORT}`);
});