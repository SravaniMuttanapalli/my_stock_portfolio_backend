# Portfolio Tracker Application

This is a full-stack application to track a user's stock portfolio. It allows users to add, view, edit, and delete stock holdings, and dynamically calculates the portfolio value based on live stock prices.

## Features

- **Dashboard**: View portfolio metrics like total value, top-performing stock, and portfolio distribution.
- **CRUD Operations**: Add, view, edit, and delete stock holdings.
- **Live Stock Prices**: The portfolio value updates dynamically using real-time stock data from an external API (e.g., Alpha Vantage, Yahoo Finance, Finnhub).
- **Responsive Design**: The frontend is built using React (or any modern frontend framework).

## Frontend
- Built with React.
- Deployed on [Vercel](https://vercel.com) or [Netlify](https://netlify.com).
- Responsive UI built with [TailwindCSS](https://tailwindcss.com) or [Bootstrap](https://getbootstrap.com).

## Backend
- Built with Java and Spring Boot.
- Exposes RESTful APIs to:
  - Add a new stock.
  - Update stock details.
  - Delete a stock.
  - Fetch all stocks and calculate portfolio value.
- Deployed on [Heroku](https://heroku.com) or [Render](https://render.com).

## Database
- MySQL or any relational database used for storing stock data.
- Stock details schema includes:
  - Stock Name
  - Ticker
  - Quantity
  - Buy Price

## How to Run the Project Locally

### Backend (Java, Spring Boot)
1. **Clone the repository**:
   ```bash
   git clone https://github.com/SravaniMuttanapalli/my_stock_portfolio_backend.git
   cd portfolio-tracker-backend
