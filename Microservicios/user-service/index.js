const express = require('express');
const app = express();
const PORT = 3001;

app.get('/users', (req, res) => {
  res.json([{ id: 1, name: 'John Doe' }]);
});

app.listen(PORT, () => {
  console.log(`User service listening on port ${PORT}`);
});