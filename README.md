# Android_Image_Manage_Util 
This is a Util project for manage image and also solve OOM problems.

[中文版](#中文版)

## Description

This project use LruCache，DiskLruCache , HttpUrlConnection , AsyncTask.
And the layout use GridView and BaseAdapter.

The main running logic is
```
Bitmap bitmap = null;

bitmap = getInLruCache( httpUrlHashKey );  // get Bitmap object from LruCache

if( bitmap != null ) {

    new SetImageView( bitmap , mViewHolder , position ); // if Bitmap is not null , set on ImageView

}else {

    bitmap = getInDiskLruCache( httpUrlHashKey );  // get Bitmap object from DiskLruCache

    if( bitmap != null ){

        new SetImageView( bitmap , mViewHolder , position ); // if Bitmap is not null , set on ImageView

    } else {
    
        downLoadFromInternet( httpUrlString , mViewHolder , position ); // download image from the internet
    
    }
}
```
All Classes's describe

| file name           | describe      |
| ------------------- |:-------------:|
|BitmapCalculateSize|resize the Bitmap object|
|BitmapManageHelper| set the input into Bitmap , use BitmapCalculateSize to resize and return a new Object |
|HashkeyMD5|use MD5 to hash the image url into a new hashKey|
|ImageLruCacheManager|main image-manager class|
|GridViewAdapter|baseAdapter example|
|SetImageView|AsyncTask example|
|ViewHolder|ViewHolder example|

## Usage

new ImageLruCacheManager class , extends BaseAdapter and Override getView().
And use this function in the getView()
```
getImage( String urlOfImage , ViewHolder CurrentViewHolder , int position );
```
you should define ViewHolder by your own situation.

* This project I also give a example by showing how Activity , BaseAdapter , ViewHolder should work.
* And a AsyncTask sub-class to set the ImageView
* ( But you can also use Handler + SoftReference , or Override runOnUiThread function in Activity 
*   sub-class to set the ImageView )

## Unsolve problem

The example just a prototype of solving image-cache problems.
Still,there's always things that can be improve.Such as :

1. gridview cells overlapping.
2. Use ThreadPoolExecutor class to manage the Thread.
3. More effective to manage the thread and imageView from each item-View.  
   when we scroll from ListView/GridView/RecyclerView , we can add a flag 
   when we scroll like 10 item , and user stil want to scroll down
   we release some bitmap resource or some resource that other Thread is using.

---

<a name="中文版"/>

# 這是一個專門給 Android 使用的 圖片管理包
這個工具類將處理 Android 圖片問題，並且解決 OOM 問題。
雖然網路上有很多類似的專案在解決圖片問題，但是此工具類希望能讓核心邏輯整合的更完整的包裝。
並且我盡力將 Activity 和 Adapter 的 責任降至最低。


## 描述

此工具類使用 LruCache，DiskLruCache，HttpUrlConnection，AsyncTask
layout 上使用 GridView 以及 BaseAdapter

核心邏輯是

```
Bitmap bitmap = null;

bitmap = getInLruCache( httpUrlHashKey );  // 從 LruCache 當中獲取 Bitmap object

if( bitmap != null ) {

    new SetImageView( bitmap , mViewHolder , position ); // 如果 Bitmap 不為空，設定在 ImageView上
    putInLruCache( httpUrlHashKey , bitmap ); // 並且將這個 object 放到 內存列隊的最前方

}else {

    bitmap = getInDiskLruCache( httpUrlHashKey );  // 從 DiskLruCache 當中獲取 Bitmap object

    if( bitmap != null ){

        new SetImageView( bitmap , mViewHolder , position ); // 如果 Bitmap 不為空，設定在 ImageView上
        putInLruCache( httpUrlHashKey , bitmap ); // 並且將這個 object 放到 內存列隊的最前方

    } else {
    
        downLoadFromInternet( httpUrlString , mViewHolder , position ); // 從網路下載
    
    }
}
```

所有類的解釋：

| 類名          | 描述      |
| ------------------- |:-------------:|
|BitmapCalculateSize|根據現在螢幕的大小重新計算Bitmap的大小|
|BitmapManageHelper| 將輸入或儲存物件轉化為Bitmap，用BitmapCalculateSize計算大小，並且重新輸出Bitmap |
|HashkeyMD5|將輸入的 Url 用 MD5 計算出雜湊碼|
|ImageLruCacheManager|主要的圖片執行類|
|GridViewAdapter|baseAdapter 的範例|
|SetImageView|AsyncTask 的範例|
|ViewHolder|ViewHolder 的範例|

## 使用

實例化 ImageLruCacheManager 類
在 BaseAdapter 的子類複寫 getView(）方法，並且調用以下方法即可
```
getImage( String urlOfImage , ViewHolder CurrentViewHolder , int position );
```
其中的 ViewHolder 請根據您的情況自行定義

在這個 Project 當中我另外撰寫了 Activity + BaseAdapter + ViewHolder
和一個專門更新 UI 的 AsyncTask 類
( 您也可以使用 Handler + SoftReference，或是在 Activity 裡面使用 runOnUiThread 來更新 UI  )

## 未解決問題

專案內的使用範例只是一個最基本的使用原型而已。
我們還可以在某些地方加強邏輯：

1. ImageView 重疊 / 錯位問題。
2. 使用 ThreadPoolExecutor 來管理線程的創造和使用。
3. 更有效的控管線程和每一個 imageView。
   可以設計比如使用 ListView/GridView/RecyclerView 滑動到每第十個物件時
   就釋放前面的 bitmap 資源或是 線程資源之類的。
