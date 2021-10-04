import React, { useContext } from 'react'
import { Data } from '../api/Data'
import { Theme } from '../util/Theme'

export default function Searchbar() {
  const { debounceHandler, searchInput } = useContext(Data)
  const { searchbar } = useContext(Theme)
  const styles = {
    parent:
      'relative flex items-stretch max-w-md mx-auto h-8 xs:h-10 rounded-md overflow-hidden shadow focus-within:shadow-md dark:shadow-none dark:focus-within:shadow-none bg-white dark:bg-gray-800',
    icon: 'grid place-items-center h-full w-10 text-sm xs:text-base text-gray-600',
    input:
      'text-xs xs:text-sm sm:text-base h-full w-full outline-none bg-transparent placeholder-shown:text-current text-gray-600 dark:text-gray-400',
  }

  return (
    <div ref={searchbar} className={styles.parent}>
      <div className={styles.icon}>
        <i className='bx bx-search'></i>
      </div>

      <input
        onChange={debounceHandler}
        ref={searchInput}
        type='text'
        className={styles.input}
        placeholder='Cari di Kota...'
      />
    </div>
  )
}
