
import './App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';



function App() {

  const [quote, setQuote] = useState('');
  const [author, setAuthor] = useState('');
  const [quotes, setQuotes] = useState([]);

  useEffect(() => {
    getRandomQuote();
  }, []);

  async function getRandomQuote() {
    const apiService = process.env.REACT_APP_SERVICE_API
    const apiVersion = process.env.REACT_APP_VERSION_API;    
    console.log('target url = http://'+apiService+':8080/api/' + apiVersion + '/quotes' );
    let resp = await axios.get(`http://localhost:8080/search`);
    console.log(resp.data);
    setQuotes(resp.data);
  }
  return (
    <>
      <div className='d-flex justify-content-center align-items-center vh-100'>
        <Card className='bg-light'>
          <Card.Header>QUOTES OF DAY</Card.Header>
          { quotes.map((variant) => (
             <Card.Body className='text-center my-4'>
              <Card.Text>
                 "{variant.quote}"   by {variant.author}
              </Card.Text>
              </Card.Body>
          ))
        }
        </Card>
      </div>
    </>
  );
}
export default App;
