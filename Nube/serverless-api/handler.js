'use strict';

module.exports.product = async (event) => {
  if (event.httpMethod === 'GET') {
    // Retornar lista de productos
    const products = [
      { id: 1, name: 'Soflan', price: 10000 },
      { id: 2, name: 'Arroz', price: 20000 },
    ];

    return {
      statusCode: 200,
      body: JSON.stringify(products),
    };
  }

  

  return {
      statusCode: 405,
      body: JSON.stringify({ message: 'Method Not Allowed' }),
  };
};

module.exports.user = async (event) => {
    if (event.httpMethod === 'GET') {
      // Retornar lista de usuarios
      const users = [
        { id: 123456, name: 'Julian Andres', lastName: 'Arbelaez', address: 'Calle 11 #55-34' },
        { id: 22222, name: 'Maria Angelica', lastName: 'Cano' , address: 'Cra 56 #22-34'},
      ];
  
      return {
        statusCode: 200,
        body: JSON.stringify(users),
      };
    }

    return {
        statusCode: 405,
        body: JSON.stringify({ message: 'Method Not Allowed' }),
    };
  };