package scala.test.lib.mysql
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Person.ddl ++ SchemaVersion.ddl
  
  /** Entity class storing rows of table Person
   *  @param id Database column id DBType(INT)
   *  @param name Database column name DBType(VARCHAR), Length(100,true) */
  case class PersonRow(id: Int, name: String)
  /** GetResult implicit for fetching PersonRow objects using plain SQL queries */
  implicit def GetResultPersonRow(implicit e0: GR[Int], e1: GR[String]): GR[PersonRow] = GR{
    prs => import prs._
    PersonRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table person. Objects of this class serve as prototypes for rows in queries. */
  class Person(_tableTag: Tag) extends Table[PersonRow](_tableTag, "person") {
    def * = (id, name) <> (PersonRow.tupled, PersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?).shaped.<>({r=>import r._; _1.map(_=> PersonRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT) */
    val id: Column[Int] = column[Int]("id")
    /** Database column name DBType(VARCHAR), Length(100,true) */
    val name: Column[String] = column[String]("name", O.Length(100,varying=true))
  }
  /** Collection-like TableQuery object for table Person */
  lazy val Person = new TableQuery(tag => new Person(tag))
  
  /** Entity class storing rows of table SchemaVersion
   *  @param versionRank Database column version_rank DBType(INT)
   *  @param installedRank Database column installed_rank DBType(INT)
   *  @param version Database column version DBType(VARCHAR), PrimaryKey, Length(50,true)
   *  @param description Database column description DBType(VARCHAR), Length(200,true)
   *  @param `type` Database column type DBType(VARCHAR), Length(20,true)
   *  @param script Database column script DBType(VARCHAR), Length(1000,true)
   *  @param checksum Database column checksum DBType(INT), Default(None)
   *  @param installedBy Database column installed_by DBType(VARCHAR), Length(100,true)
   *  @param installedOn Database column installed_on DBType(TIMESTAMP)
   *  @param executionTime Database column execution_time DBType(INT)
   *  @param success Database column success DBType(BIT) */
  case class SchemaVersionRow(versionRank: Int, installedRank: Int, version: String, description: String, `type`: String, script: String, checksum: Option[Int] = None, installedBy: String, installedOn: java.sql.Timestamp, executionTime: Int, success: Boolean)
  /** GetResult implicit for fetching SchemaVersionRow objects using plain SQL queries */
  implicit def GetResultSchemaVersionRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[java.sql.Timestamp], e4: GR[Boolean]): GR[SchemaVersionRow] = GR{
    prs => import prs._
    SchemaVersionRow.tupled((<<[Int], <<[Int], <<[String], <<[String], <<[String], <<[String], <<?[Int], <<[String], <<[java.sql.Timestamp], <<[Int], <<[Boolean]))
  }
  /** Table description of table schema_version. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class SchemaVersion(_tableTag: Tag) extends Table[SchemaVersionRow](_tableTag, "schema_version") {
    def * = (versionRank, installedRank, version, description, `type`, script, checksum, installedBy, installedOn, executionTime, success) <> (SchemaVersionRow.tupled, SchemaVersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (versionRank.?, installedRank.?, version.?, description.?, `type`.?, script.?, checksum, installedBy.?, installedOn.?, executionTime.?, success.?).shaped.<>({r=>import r._; _1.map(_=> SchemaVersionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column version_rank DBType(INT) */
    val versionRank: Column[Int] = column[Int]("version_rank")
    /** Database column installed_rank DBType(INT) */
    val installedRank: Column[Int] = column[Int]("installed_rank")
    /** Database column version DBType(VARCHAR), PrimaryKey, Length(50,true) */
    val version: Column[String] = column[String]("version", O.PrimaryKey, O.Length(50,varying=true))
    /** Database column description DBType(VARCHAR), Length(200,true) */
    val description: Column[String] = column[String]("description", O.Length(200,varying=true))
    /** Database column type DBType(VARCHAR), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Column[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column script DBType(VARCHAR), Length(1000,true) */
    val script: Column[String] = column[String]("script", O.Length(1000,varying=true))
    /** Database column checksum DBType(INT), Default(None) */
    val checksum: Column[Option[Int]] = column[Option[Int]]("checksum", O.Default(None))
    /** Database column installed_by DBType(VARCHAR), Length(100,true) */
    val installedBy: Column[String] = column[String]("installed_by", O.Length(100,varying=true))
    /** Database column installed_on DBType(TIMESTAMP) */
    val installedOn: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("installed_on")
    /** Database column execution_time DBType(INT) */
    val executionTime: Column[Int] = column[Int]("execution_time")
    /** Database column success DBType(BIT) */
    val success: Column[Boolean] = column[Boolean]("success")
    
    /** Index over (installedRank) (database name schema_version_ir_idx) */
    val index1 = index("schema_version_ir_idx", installedRank)
    /** Index over (success) (database name schema_version_s_idx) */
    val index2 = index("schema_version_s_idx", success)
    /** Index over (versionRank) (database name schema_version_vr_idx) */
    val index3 = index("schema_version_vr_idx", versionRank)
  }
  /** Collection-like TableQuery object for table SchemaVersion */
  lazy val SchemaVersion = new TableQuery(tag => new SchemaVersion(tag))
}