import React from 'react'

function PersonlistChild({persons}) {
  return (
    <div>
        {persons.map((person) => <h3>{person.name}, My age is {person.age} and Adrress is {person.address}</h3>)}
    </div>
  )
}

export default PersonlistChild