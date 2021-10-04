import React, { useContext } from 'react'
import MainLayout from '../layout/MainLayout'
import CardLayout from '../layout/CardLayout'
import Card from '../component/Card'
import Searchbar from '../component/Searchbar'
import { Data } from '../api/Data'
import { Theme } from '../util/Theme'

export default function Main() {
  const { data, err } = useContext(Data)
  const { heading } = useContext(Theme)

  const styles = {
    heading:
      'text-center text-xl xs:text-2xl md:text-4xl font-bold tracking-tight text-gray-700 dark:text-gray-300 leading-tight',
  }

  return (
    <MainLayout>
      <h1 ref={heading} className={styles.heading}>
        Gimana Cuaca Hari ini?
      </h1>
      <Searchbar />
      <CardLayout>
        {!data && <LoadingState />}
        {data && <Card data={data} status={err} />}
      </CardLayout>
    </MainLayout>
  )
}

function LoadingState() {
  const styles = {
    loadingStateBody: 'grid place-items-center w-full h-52',
  }
  return (
    <div className={styles.loadingStateBody}>
      <div className='dots-7'></div>
    </div>
  )
}
