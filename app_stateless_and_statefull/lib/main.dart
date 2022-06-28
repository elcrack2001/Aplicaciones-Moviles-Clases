import 'package:flutter/material.dart';

void main() {
  runApp(MyStatefullApp());
}

class MyStateLessApp extends StatelessWidget {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejem de StatelessWidget"),
        ),
        body: Center(
          child: Text(
              counter.toString(),
          style: TextStyle(fontSize: 40),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one),
          onPressed: (){
            counter++;
            print(counter); // Para imprimir en la consola
          }, //onPressed
        ),
      ),
    );
  }
}

class MyStatefullApp extends StatefulWidget {
  const MyStatefullApp({Key? key}) : super(key: key);

  @override
  State<MyStatefullApp> createState() => _MyStatefullAppState();
}

class _MyStatefullAppState extends State<MyStatefullApp> {
  int counter = 0;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejem de StatefullWidget"),
        ),
        body: Center(
          child: Text(
            counter.toString(),
            style: TextStyle(fontSize: 40),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one),
          onPressed: (){
            setState((){
              counter++;
              print(counter); // Para imprimir en la consola
            });
          }, //onPressed
        ),
      ),
    );
  }
}


