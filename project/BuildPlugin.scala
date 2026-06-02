import sbt._, Keys._
import sbt.plugins.{JvmPlugin, SbtPlugin}

object BuildPlugin extends AutoPlugin {
  override def trigger = allRequirements

  override def requires = JvmPlugin

  override lazy val projectSettings = baseSettings

  def baseSettings: Seq[sbt.Def.Setting[_]] =
    Seq(
      resolvers += Resolver.scalaNightlyRepository,
      scalaVersion := "3.8.3",
      scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xkind-projector"),
    )
}
