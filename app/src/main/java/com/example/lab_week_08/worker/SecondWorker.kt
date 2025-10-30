package com.example.lab_week_08.worker

import android.content.Context
import androidx.work.WorkerParameters
import androidx.work.Data
import androidx.work.Worker

class SecondWorker(
    context: Context, workerParams: WorkerParameters
) : Worker(context, workerParams) {
    // this function executes the predefined process based on the input
    // and return an output after it's done
    override fun doWork(): Result {
        //get the parameter input
        val id = inputData.getString(INPUT_DATA_ID)

        //sleep the process for 3 seconds
        Thread.sleep(3000L)

        //build the output based on process result
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, "$id")
            .build()

        //return the output
        return Result.success(outputData)
    }
    companion object {
        const val INPUT_DATA_ID = "inId"
        const val OUTPUT_DATA_ID = "outId"
    }
}