/*
 * Copyright 2018-2019 Gabriel Volpe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gvolpe.tracer

import cats.effect._
import cats.syntax.functor._
import com.github.gvolpe.tracer.instances.tracerlog._

object Server extends IOApp {

  // For a default instance with header name "Trace-Id" just use `import com.github.gvolpe.tracer.instances.tracer._`
  implicit val tracer = Tracer.create[IO]("Flow-Id")

  override def run(args: List[String]): IO[ExitCode] =
    new Main[IO].server.as(ExitCode.Success)

}
