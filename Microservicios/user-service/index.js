const express = require('express');
const app = express();
const PORT = 3001;

app.get('/users', (req, res) => {
  res.json([{ id: 1, name: 'Juan Camilo' }]);
});

app.listen(PORT, () => {
  console.log(`Servicio de usuario escuchando en el puerto ${PORT}`);
});