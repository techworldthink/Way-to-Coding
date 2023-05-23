import React from 'react'
import PersonlistChild from './PersonlistChild';

function ListMap() {
    const name = ['ashok','kumar','reddy'];
    const persons = [{
            name: 'ashok',
            age: 25,
            address: 'hyd'
        }
        ,{
            name: 'kumar',
            age: 26,
            address: 'hyd'
        },
        {
            name: 'reddy',
            age: 27,
            address: 'hyd'
        }
    ] // List of objects
    return (
        <div>
            <h3>ListMap Component</h3>
            <ul>
                {name.map((name , index) => <li>{index+1}  {name}</li>)} {/* Mapping the list  */}
            </ul>

            <div>
                <PersonlistChild persons={persons}/> {/* Passing the list of objects as props */}
            </div>
        </div>
    )
}

export default ListMap