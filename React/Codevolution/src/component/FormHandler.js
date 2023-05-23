import React from 'react'
import {useState} from 'react'

function FormHandler() {
    const [name, setName] = useState(""); // initial value is empty
    const [age, setAge] = useState(0)
    const [address, setAddress] = useState('')

    const changeName = (e) => {
        setName(e.target.value) // e.target.value is the value entered in the input field
    }

    const changeAge = (e) => {
        setAge(e.target.value)
    }

    const changeAddress = (e) => {
        setAddress(e.target.value)
    }

    const submitForm = (e) => { // e is the event object
        e.preventDefault();
        console.log(name, age, address)
    }
    
    // Styling
    const formStyle = {
        border: '1px solid black',
        padding: '10px',
        margin: '10px',
        width: '50%',
        backgroundColor: 'lightblue'
    }

    const inputStyle = {
        margin: '10px',
        width: '50%',
    }
    const buttonStyle = {
        margin: '10px',
        width: '50%',
        backgroundColor: 'lightgreen',
        border: '1px solid black'
    }


  return (
    <div>
        <h3>FormHandler Component</h3>
        <form onSubmit={submitForm} style={formStyle}> {/* onSubmit is an event handler that calls the submitForm function */}
            <div>
                <label>Name</label>
                <input type="text" value={name} onChange={changeName} style={inputStyle}/> {/* onChange is an event handler that calls the changeName function */}
                <br/>
                <label>Age</label>
                <input type="text" value={age} onChange={changeAge} style={inputStyle}/>
                <br/>
                <label>Address</label>
                <input type="text" value={address} onChange={changeAddress} style={inputStyle}/>
                <br/>
                <button type="submit" style={buttonStyle}>Submit</button>

            </div>
        </form>
        <div>
            <h3>Name:
                {name ? name : "  Enter your name" }
            </h3>
            <h3>Age: { age ? age : " Enter your age" }</h3>
            <h3>Address: { address ? address : " Enter your address" }</h3>
        </div>

    </div>
  )
}

export default FormHandler