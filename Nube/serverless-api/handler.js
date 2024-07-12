'use strict';

module.exports.auth = async (event) => {
  const { username, password } = JSON.parse(event.body);

  // Lógica de autenticación simple
  if (username === 'user' && password === 'pass') {
    return {
      statusCode: 200,
      body: JSON.stringify({ token: 'fake-jwt-token' }),
    };
  }

  return {
      statusCode: 401,
      body: JSON.stringify({ message: 'Unauthorized' }),
  };
};

module.exports.product = async (event) => {
  if (event.httpMethod === 'GET') {
    // Retornar lista de productos
    const products = [
      { id: 1, name: 'Product 1', price: 100 },
      { id: 2, name: 'Product 2', price: 200 },
    ];

    return {
      statusCode: 200,
      body: JSON.stringify(products),
    };
  }

  /*if (event.httpMethod === 'POST') {
    // Agregar nuevo producto
    const product = JSON.parse(event.body);

    return {
      statusCode: 201,
      body: JSON.stringify(product),
    };
  }*/

  return {
      statusCode: 405,
      body: JSON.stringify({ message: 'Method Not Allowed' }),
  };
};
