import React from 'react'

export default function MainLayout(props) {
  return (
    <main className='breakpoint mt-4 xs:mt-6 sm:mt-8 space-y-1 xs:space-y-2 sm:space-y-4 md:space-y-6'>
      {props.children}
    </main>
  )
}
