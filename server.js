import express from 'express';  // Use 'import' instead of 'require'
import cors from 'cors';        // Use 'import' instead of 'require'
import dotenv from 'dotenv';    // Use 'import' instead of 'require'
import fetch from 'node-fetch'; // Use 'import' instead of 'require'

// Load environment variables from .env file
dotenv.config();

const app = express();
const port = 8081; // Set the backend to run on port 8081

// Use middlewares
app.use(cors());
app.use(express.json());

// Example route for a GET request
app.get('/', (req, res) => {
  res.send('Hello from the backend server!');
});

// Example route for your stock API
app.get('/api/stocks', (req, res) => {
  const stocks = [
    { id: 1, ticker: 'AAPL', price: 150.00 },
    { id: 2, ticker: 'GOOG', price: 2800.00 },
  ];
  res.json(stocks);  // Send the stocks as a JSON response
});

// Start the server
app.listen(port, () => {
  console.log(`Server is running on http://localhost:8081`);
});
