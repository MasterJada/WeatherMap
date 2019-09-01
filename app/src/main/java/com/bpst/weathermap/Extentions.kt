package com.bpst.weathermap


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable



operator fun  CompositeDisposable.plusAssign(d: Disposable){
    this.add(d)
}

