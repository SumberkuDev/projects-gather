import React from 'react'

export default function NavbarLayout(props) {
  return (
    <header className='breakpoint flex items-center justify-between h-12 sm:mt-2 md:mt-4 lg:mg-6'>
      {props.children}
    </header>
  )
}
